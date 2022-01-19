package com.qiwogames.kotlin_quizz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import model.QuestionBanque
import model.Questions

class QuizzActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)


        val nomJoueur: TextView = findViewById(R.id.nom_joueur);
        val questionsTexte: TextView = findViewById(R.id.questions);
        val reponse1: Button = findViewById(R.id.reponse_1);
        val reponse2: Button = findViewById(R.id.reponse_2);
        val reponse3: Button = findViewById(R.id.reponse_3);
        val reponse4: Button = findViewById(R.id.reponse_4);

        //Afficher le nom du joueur
        //Recup de la cle MainActivity
        var nomJoueurEntrer:String = intent.getStringExtra("nom").toString();
        nomJoueur.text = "Bonjour : $nomJoueurEntrer"

        //Instance de la classe des questions (1 string + liste de string)
        val question1 = Questions();
        val reponsesQuestion1 = listOf<String>("Mario", "Sonic", "Alex Kid", "Rayman")

        questionsTexte.text = question1.questions
        reponse1.text = reponsesQuestion1[0]
        reponse2.text = reponsesQuestion1[1]
        reponse3.text = reponsesQuestion1[2]
        reponse4.text = reponsesQuestion1[3]

        var tableauReponses: Array<Button> = arrayOf(reponse1, reponse2, reponse3, reponse4)

        //La bonne reponse
        val laBonneReponse = question1.bonneReponse

        tableauReponses[0]

        tableauReponses[0].setOnClickListener{
            Toast.makeText(this,"FAUX", Toast.LENGTH_SHORT).show();
        }

        reponse2.setOnClickListener{
            Toast.makeText(this,"VRAI", Toast.LENGTH_SHORT).show();

        }

        reponse3.setOnClickListener{
            Toast.makeText(this,"FAUX", Toast.LENGTH_SHORT).show();
        }

        reponse4.setOnClickListener{
            Toast.makeText(this,"FAUX", Toast.LENGTH_SHORT).show();
        }



    }
}

