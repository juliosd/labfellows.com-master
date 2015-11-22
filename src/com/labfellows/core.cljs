(ns com.labfellows.core
  (:require [taoensso.encore :as enc :refer (tracef debugf infof warnf errorf)]))

(defn start! [] (debugf "App is running, from core"))
