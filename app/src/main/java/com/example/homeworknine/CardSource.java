package com.example.homeworknine;

public interface CardSource {
    int size();
    CardData getCardData(int position);

    void deleteCardData(int position);
    void updateCardData(int position, CardData newCardData);
    void addCardData(CardData newCardData);
    void clearCardData();
}
