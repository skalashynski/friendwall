(defproject friendwall "0.1.0-SNAPSHOT"
  :description "Demo small project for a small social network"
  :url "http://github.com/skalashynski.git"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.0"]
                 [compojure "1.6.2"]
                 [ring/ring-defaults "0.3.2"]
                 ]
  :repl-options {:init-ns friendwall.core}
  :main friendwall.core
  :target-path "target/%s"

  )
