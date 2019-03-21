package com.example.blbliodb;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AllBookActivity extends AppCompatActivity {

    LinearLayout layoutBooks;

    private List<Book> listBooks;
    BiblioDatabase bdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bdb = BiblioDatabase.getDatabase(this);

        layoutBooks = findViewById(R.id.layoutBooks);

        new GetBookTask().execute();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AddBookActivity.class);
                startActivity(intent);
            }
        });
    }

    private class GetBookTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            listBooks = bdb.bookDao().getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            for (Book book : listBooks) {
                TextView tvBookTitle = new TextView(AllBookActivity.this);
                tvBookTitle.setText(book.Titre);
                tvBookTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                layoutBooks.addView(tvBookTitle);
            }

        }

    }

}
