(ns friendwall.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [config.core :refer [env]]
            [rum.core :refer [defc render-static-markup]]
            )
  (:gen-class))

(defc template [headline component]
  [:div {:id    "main-div"
         :class "main-page-div"
         }
   [:h1 headline]
   [:ul {:class "nav"}
    [:li [:a {:href "/"} "Home"]]
    [:li [:a {:href "/friends"} "Friends"]]
    ]
   (component)])

(defc main-page []
[:p "This is tha main page. You're welcome"]
  )

(defc friends-page []
  [:p "This is the friends page, empty yet"]
  )

(defroutes app
           (GET "/" [] (render-static-markup (template "Hello world!" main-page)))
           (GET "/friends" [] (render-static-markup (template "No friends, yet" friends-page)))
           )

(defn app-handler [request]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "<html><body>Hello, There!</body></html>"
   }
  )

(defn -main
  "I don't do a whole lot."
  [& args]
  (run-jetty (wrap-defaults app site-defaults) {:port (:port env)})

  )
