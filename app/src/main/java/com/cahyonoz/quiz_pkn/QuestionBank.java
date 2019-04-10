package com.cahyonoz.quiz_pkn;

public class QuestionBank {
    private String textQuestions [] = {
            "1. Apa warna bendera Indonesia?",
            "2. Apa lambang negara Indonesia ?",
            "3. Siapa Presiden pertama Indonesia?",
            "4. siapa prseiden Indonesia sekarang?",
            "5. tahun berapa indonesia merdeka",
            "6. Tahun berapa sekarang ?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"Merah - Putih", "Putih - Merah", "kuning", "hijau"},
            {"Macan Melayu", "Burung Garuda", "Gajah", "Burung Merpati"},
            {"Soeharto", "Joko Widodo", "Gusdur", "Ir Soekarno"},
            {"Megawati", "Prabowo", "Bj Habibi", "Joko Widodo"},
            {"1999", "2018", "1945", "2000"},
            {"1999", "2000", "2019", "2011"}
    };

    private String mCorrectAnswers[] = {"Merah - Putih", "Burung Garuda", "Ir Soekarno", "Joko Widodo", "1945", "2019"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
