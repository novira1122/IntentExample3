package id.ac.polbeng.noviraasnani.intentexample3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.polbeng.noviraasnani.intentexample3.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil bundle dari intent
        val bundle = intent.getBundleExtra("main_activity_data")
        val height = bundle?.getDouble("height")
        val weight = bundle?.getDouble("weight")

        // Tampilkan nilai height dan weight
        binding.txtIntentData.text = "Height: ${height ?: "N/A"} | Weight: ${weight ?: "N/A"}"

        binding.btnCalculate.setOnClickListener {
            val resultIntent = Intent()
            var bmiValue = 0.0

            // Hitung BMI jika height dan weight tidak null
            if (height != null && weight != null) {
                bmiValue = 703 * (weight / (height * height))
            }

            // Kirim kembali nilai BMI
            resultIntent.putExtra("second_activity_data", bmiValue)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
