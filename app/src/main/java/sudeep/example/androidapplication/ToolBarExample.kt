package sudeep.example.androidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class ToolBarExample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar_example)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

//        to set the title
        toolbar.title = "ToolBar Example";

//        to set the logo
//        toolbar.setLogo(R.drawable.demoimg)


        // replaces the toolbar as an actionbar
//        actionbar to htakrke wha par toobar rkh dega
        setSupportActionBar(toolbar)


        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Back Arrow", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.action_settings) {
            Toast.makeText(applicationContext, "Setting Menu", Toast.LENGTH_LONG).show()
            return true
        } else if (id == R.id.action_email) {
            Toast.makeText(applicationContext, "Email Menu", Toast.LENGTH_LONG).show()
            return true
        } else if (id == R.id.action_add) {
            Toast.makeText(applicationContext, "User Menu", Toast.LENGTH_LONG).show()
            return true
        }
        return super.onOptionsItemSelected(item);
    }
}