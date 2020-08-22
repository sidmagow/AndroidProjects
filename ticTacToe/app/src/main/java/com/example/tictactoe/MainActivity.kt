package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

const val TAG="Button Clicked"
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var board: Array<Array<Button>>
    var Player:Boolean= true
    var turn_count=0

    //explore more on how to create array like this
    var boardStatus =  Array(size = 3){IntArray(3)}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            board= arrayOf(
                arrayOf(button1,button2,button3),
                arrayOf(button4,button5,button6),
                arrayOf(button7,button8,button9)
            )

        initializeBoardStatus()

        for(i:Array<Button> in board){
            for (button in i){
                 button.setOnClickListener(this)
            }
        }

        button10.setOnClickListener {
            Player=true
            turn_count=0
            initializeBoardStatus()
        }


    }

    private fun initializeBoardStatus() {
        for (i in 0..2){
            for (j in 0..2){
                boardStatus[i][j]=-1
                board[i][j].isEnabled= true
                board[i][j].text =""
            }
        }
        textView1.setText("Player X Turn")
    }

    override fun onClick(view: View) {

        when(view.id){
            R.id.button1->{
                updateButton(0,0,Player)
            }
            R.id.button2->{
                updateButton(0,1,Player)
            }
            R.id.button3->{
                updateButton(0,2,Player)
            }
            R.id.button4->{
                updateButton(1,0,Player)
            }
            R.id.button5->{
                updateButton(1,1,Player)
            }
            R.id.button6->{
                updateButton(1,2,Player)
            }
            R.id.button7->{
                updateButton(2,0,Player)
            }
            R.id.button8->{
                updateButton(2,1,Player)
            }
            R.id.button9->{
                updateButton(2,2,Player)
            }

        }
    }

    private fun updateButton(row: Int, col: Int, player: Boolean) {
        var text:String
        if(player){
             text="X"
            Player=false
            textView1.setText("Player O Turn")
        } else {
            text="O"
            Player=true
            textView1.setText("Player X Turn")
        }
        var value= if(player) 1 else  0
        board[row][col].apply {
            isEnabled=false
            setText(text)
        }
        boardStatus[row][col]=value
        turn_count+=1

        if (turn_count==9){
            textView1.setText("MATCH DRAW")
        }else{
           winnercheck(row,col)

        }
    }

    private fun disableRemaining(){
        for (i in 0..2){
            for (j in 0..2){
                if(boardStatus[i][j]==-1){
                    board[i][j].isEnabled=false
                }

            }
        }
    }

    private fun winnercheck(row: Int, col: Int) {
        for (i in 0..2){

            if(boardStatus[i][0]!=-1&& boardStatus[i][0]==boardStatus[i][1]&& boardStatus[i][0]==boardStatus[i][2]){
                if(boardStatus[i][0]==1){
                    textView1.text = "Player X Won"

                }else{
                    textView1.text = "Player O Won"

                }
                disableRemaining()
                return
            }
        }

        for (i in 0..2){
            if(boardStatus[0][i]!=-1&&boardStatus[0][i]==boardStatus[1][i]&& boardStatus[0][i]==boardStatus[2][i]){
                if(boardStatus[0][i]==1){
                    textView1.text = "Player X Won"

                }else{
                    textView1.text = "Player O Won"

                }
                disableRemaining()
                return

            }
        }

        if(boardStatus[0][0]!=-1&&boardStatus[0][0]==boardStatus[1][1] && boardStatus[0][0]==boardStatus[2][2]){
                if(boardStatus[0][0]==1){
                    textView1.setText("Player X Won")

                }else{
                    textView1.setText("Player O Won")

                }
            disableRemaining()
            return
            }

        if(boardStatus[2][0]!=-1&&boardStatus[2][0]==boardStatus[1][1] && boardStatus[2][0]==boardStatus[0][2]){
            if(boardStatus[2][0]==1){
                textView1.setText("Player X Won")

            }else{
                textView1.setText("Player O Won")

            }
            disableRemaining()
            return
        }


    }
}