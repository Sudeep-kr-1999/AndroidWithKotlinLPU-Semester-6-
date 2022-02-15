package sudeep.example.androidapplication

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class DateTimePickerExample : AppCompatActivity() {
    lateinit var btnDatePicker: Button
    lateinit var btnTimePicker: Button
    lateinit var txtDate: EditText
    lateinit var txtTime: EditText

    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0
    private var mHour: Int = 0
    private var mMinute: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_picker_example)
        btnDatePicker = findViewById(R.id.datePicker)
        btnTimePicker = findViewById(R.id.timePicker)
        txtDate = findViewById(R.id.txtDate)
        txtTime = findViewById(R.id.txtTime)
        btnDatePicker.setOnClickListener {

//            get current date
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH];
            mDay = c[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->
                txtDate.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
            }, mYear, mMonth, mDay)
            datePickerDialog.show();
        }

        btnTimePicker.setOnClickListener {
//            get current time
            val c = Calendar.getInstance();
            mHour = c[Calendar.HOUR_OF_DAY];
            mMinute = c[Calendar.MINUTE];

//            launch time picker
            val timePickerDialog = TimePickerDialog(this, { view, hourOfDay, minute ->
                var hour = hourOfDay
                val am_pm = if (hour < 12) {
                    "AM"
                } else {
                    "PM"
                }
                if (am_pm == "PM") {
                    hour -= 12
                }
                if (hour == 0) {
                    hour += 12
                }

                if (minute < 10) {
                    txtTime.setText("${hour}:0${minute} $am_pm");
                } else {
                    txtTime.setText("${hour}:${minute} $am_pm");
                }
            }, mHour, mMinute, false)
            timePickerDialog.show();
        }
    }
}