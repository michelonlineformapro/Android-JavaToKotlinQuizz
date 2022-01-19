package model

import java.io.Serializable

class QuestionBanque(arrayOf: Array<Questions>) : Serializable  {

    private lateinit var questionListe: List<Questions>
    private var questionIndex: Int = 0;

    fun QuestionBanque(maQuestionListe: List<Questions>){
        questionListe = maQuestionListe
        questionListe.shuffled()
    }

    fun getQuestionCourante():Questions{
        return questionListe[questionIndex]
    }

    fun getNextQuestion():Questions{
        questionIndex++
        return getQuestionCourante()
    }
}