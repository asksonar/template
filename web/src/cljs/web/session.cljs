(ns web.session
  (:require [reagent.core :as r]))

(defonce state (r/atom {}))

(defn user []
  (:user @state))

(defn page []
  (:page @state))
