(ns friendwall.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [config.core :refer [env]]
            )
  (:gen-class))

(defroutes app
           (GET "/" [] "<h1>Hello World</h1>")
           (GET "/friends" [] "<h1>There are no friends yet</h1>")
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
