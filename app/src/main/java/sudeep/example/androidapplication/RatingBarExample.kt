package sudeep.example.androidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class RatingBarExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar_example)
        val simpleRatingBar = findViewById<RatingBar>(R.id.simpleRatingBar)
        val simpleRating = findViewById<RatingBar>(R.id.simpleRating)
        val submitBtn = findViewById<Button>(R.id.submitButton)
        submitBtn.setOnClickListener {
            val totalStars = "Total Stars: " + simpleRatingBar.numStars;
            val rating = "Rating : " + simpleRatingBar.rating;
            Toast.makeText(this, """$totalStars $rating""".trimIndent(), Toast.LENGTH_LONG).show();
        }
        simpleRating.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
                Toast.makeText(this, "Rating $rating $fromUser", Toast.LENGTH_LONG).show();
            }
    }
}