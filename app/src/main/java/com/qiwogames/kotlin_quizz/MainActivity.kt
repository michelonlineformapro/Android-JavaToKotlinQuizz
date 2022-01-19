package com.qiwogames.kotlin_quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import model.User


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Utilisation des variables et assignation au id du xml
        val titre: TextView = findViewById(R.id.titre_accueil);
        val champNom: EditText = findViewById(R.id.nom_input);
        val boutonValide: Button = findViewById(R.id.valide_nom);

        val userNameClass = User()
        userNameClass.setName(champNom.text.toString())


        //Par defaut on desactive le bouton si le champ nom n'est pas rempli
        boutonValide.isEnabled = false;
        //On observe l'etat de input
        champNom.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(champNom.text.isNotEmpty()){
                    boutonValide.isEnabled = true
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        //Le clic sur le bouton et la validation
        boutonValide.setOnClickListener {
            val valueInput:String = champNom.text.toString()
            //intent = event javascript
            val intent = Intent(this, QuizzActivity::class.java);
            //On passe les donéées de input comme cles + valeurs
            intent.putExtra("nom", valueInput)
            startActivity(intent);
        }

    }
}