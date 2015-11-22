(set-env!
 :source-paths    #{"src"}
 :resource-paths  #{"resources"}
 :dependencies   '[[adzerk/boot-cljs      "0.0-2814-0" :scope "test"]
                   [adzerk/boot-cljs-repl "0.1.9"      :scope "test"]
                   [adzerk/boot-reload    "0.2.4"      :scope "test"]
                   [pandeiro/boot-http    "0.6.2"      :scope "test"]
                   [tailrecursion/boot-hoplon    "0.1.0-SNAPSHOT"  :scope "test"]

                   ;; App
                   [org.clojure/clojurescript    "0.0-3196"        :scope "test"]
                   [tailrecursion/hoplon         "6.0.0-SNAPSHOT"]
                   [jayq                         "2.5.4"]
                   [jarohen/chord                "0.6.0"]
                   [com.taoensso/encore          "1.23.1"]
                   [com.andrewmcveigh/cljs-time  "0.3.3"]
                   [markdown-clj                 "0.9.64"]])


(require
 '[adzerk.boot-cljs           :refer :all]
 '[pandeiro.boot-http         :refer [serve]]
 '[tailrecursion.boot-hoplon  :refer :all]
 '[adzerk.boot-reload         :refer [reload]])


(deftask dev []
  (comp (serve)
        (watch)
        (speak)
        (hoplon)
        (reload :on-jsload 'com.labfellows.core/start!)
        (cljs :source-map true :optimizations :none)))


(deftask build []
  (comp 
   (hoplon)
   (cljs :optimizations :advanced)))

