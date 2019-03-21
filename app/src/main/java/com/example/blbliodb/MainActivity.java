package com.example.blbliodb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Book> listBooks;
    BiblioDatabase bdb;

    public TextView firstBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstBook = (TextView) findViewById(R.id.TextAppName);

        bdb = BiblioDatabase.getDatabase(this);

        //new InsertBookTask().execute();
        new GetBookTask().execute();
    }

    private class InsertBookTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            Book firstBook = new Book();
            firstBook.Auteur = "Isaac Asimov";
            firstBook.Titre = "Fondation";
            firstBook.Resume = "Apres l'effondrement de l'empire la Fondation cherche à preserver le savoir";

            bdb.bookDao().insertBook(firstBook);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Toast.makeText(MainActivity.this, "nouvelle entrée", Toast.LENGTH_SHORT).show();
        }

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

            firstBook.setText(listBooks.get(0).Auteur);

        }

    }

    private class deleteBook extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}