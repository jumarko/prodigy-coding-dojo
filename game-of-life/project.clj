(defproject game-of-life "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [midje "1.6.3"]
                 [lein-gorilla "0.3.4"]]
  :main ^:skip-aot game-of-life.core
  :plugins [[lein-gorilla "0.3.4"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
