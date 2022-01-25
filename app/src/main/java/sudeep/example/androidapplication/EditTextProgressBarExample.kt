package sudeep.example.androidapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

class EditTextProgressBarExample : AppCompatActivity() {
    private var i=0;
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_progress_bar_example)
        val editText=findViewById<EditText>(R.id.et_progress)
        val progressBar=findViewById<ProgressBar>(R.id.progressbar)
        val textView=findViewById<TextView>(R.id.tvProgress)
        editText.addTextChangedListener {
            i=editText.length()
            progressBar.progress=i
            textView.text=i.toString()+"/"+progressBar.max
        }
    }
}