package com.example.homeworknine;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class CardSourceImpl implements CardSource {

    private List<CardData> dataSource;

    private Resources resources;

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    public CardSourceImpl(Resources resources) {
        dataSource = new ArrayList<>();
        this.resources = resources;
    }

    public CardSourceImpl init(){

        String[] note = resources.getStringArray(R.array.item_notes);
        String[] description = resources.getStringArray(R.array.item_description);

        for(int i = 0; i < note.length; i++){
            dataSource.add(new CardData(note[i], description[i]));
        }
        return this;
    }
}
