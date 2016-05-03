(ns web.controls
  (:require [reagent.core :as r]
            [web.session :refer [state]]))

(defn set-page! [page]
  (swap! state assoc-in [:page] page))

(defn set-user! [user]
  (swap! state assoc-in [:user] user))
