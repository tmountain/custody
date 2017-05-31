(ns custody.core
  (:require
   [clj-time.core :as t]
   [clj-time.format :as f]))

(def schedule [:with, :with, :away, :away, :with, :with, :with,
               :away, :away, :with, :with, :away, :away, :away])

(def start-date (t/date-time 2017 5 29))

(defn gen-dates
  [start-date days]
  (for [day (range days)]
    (f/unparse (f/formatter "yyyy-MM-dd (E)")
      (t/plus start-date (t/days day)))))

(defn -main [& args]
  (doseq
    [[day with] (map vector (gen-dates start-date 90) (cycle schedule))]
    (println (str day " " (name with)))))
