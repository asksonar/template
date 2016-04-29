(ns web.app
  (:require [reagent.core :as r]
            [cljsjs.semantic-ui]))

(defonce ^:private user (r/atom "jchu"))
(defonce ^:private users (r/atom [{:id 1 :username "jchu"}
                                  {:id 2 :username "stacy"}]))


(defn dropdown [{:keys [value] :as options} choices]
  (r/create-class
    {:component-did-mount
       (fn [component]
         (let [dom-node (r/dom-node component)]
           (.dropdown (js/$ dom-node) #js {:match    "text"
                                           :onChange (fn [new-value]
                                                       (reset! value new-value))})))
     :component-did-update
       (fn [component]
         (let [dom-node (r/dom-node component)]
           (.dropdown (js/$ dom-node) "set selected" @value)
           (.dropdown (js/$ dom-node) "refresh")))
     :reagent-render
       (fn [{:keys [value] :as options} _]
         (let [value @value]
           [:div.ui.fluid.search.selection.dropdown
            [:input {:type "hidden" :name "choice" :value value}]
            [:i.dropdown.icon]
            [:div.default.text "Select choice"]
            [:div.menu
             (doall (for [{:keys [value text]} choices]
                      (do
                        (js/console.log value text)
                        (conj
                          ^{:key (str "choice-" value)}
                          [:div.item {:data-value value}]
                          text))))]]))}))

(defn some-component []
  [:div
   [:h3 "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"]
    " text."]])

(defn calling-component []
  [:div "Parent component"
   [some-component]
   [dropdown {:value user}
    (for [user @users]
      {:value (:id user) :text (:username user)})]])

(defn init []
  (r/render-component [calling-component]
    (.getElementById js/document "container")))
