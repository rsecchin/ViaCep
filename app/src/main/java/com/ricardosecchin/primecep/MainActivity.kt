package com.ricardosecchin.primecep

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.ricardosecchin.primecep.model.CEP
import com.ricardosecchin.primecep.services.CepService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var etCEP: EditText
    lateinit var btnBuscarPorCEP: Button
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etCEP = findViewById(R.id.et_cep)
        btnBuscarPorCEP = findViewById(R.id.btn_buscar_por_cep)
        progressBar = findViewById(R.id.progress_bar)

        btnBuscarPorCEP.setOnClickListener {

            progressBar.visibility = View.VISIBLE
            val call = CepService().service().getEnderecoByCEP(etCEP.text.toString())

            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) = response.let {

                    val CEPs: CEP? = it.body()

                    Log.i("CEP", CEPs.toString())

                    progressBar.visibility = View.INVISIBLE

                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    Log.e("Erro", t?.message)
                    progressBar.visibility = View.INVISIBLE
                }

            })
        }
    }
}
