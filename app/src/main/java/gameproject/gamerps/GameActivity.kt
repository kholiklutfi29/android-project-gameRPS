package gameproject.gamerps

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    lateinit var computerImageView: ImageView
    lateinit var rockImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var scissorsImageButton: ImageButton
    lateinit var resultImageView: ImageView

    private fun initComponent(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun startGame(option: String){
        val computerChoice = Game.computerPick()
        computerImageView.setImageResource(Game.pickDrawable(computerChoice))

        when{
            Game.isDraw(option, computerChoice) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option,computerChoice) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    private fun initListener(){
        val rock = "ROCK"
        val paper = "PAPER"
        val scissors = "SCISSORS"

        rockImageButton.setOnClickListener { startGame(rock) }
        paperImageButton.setOnClickListener { startGame(paper) }
        scissorsImageButton.setOnClickListener { startGame(scissors) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponent()
        initListener()

    }

}