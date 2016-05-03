(ns web.pages.posts
  (:require [reagent.core :as r]))

(defn posts-page []
  [:div.posts
    [:div.post "Post 1"]
    [:div.post "Post 2"]
    [:div.post "Post 3"]])
