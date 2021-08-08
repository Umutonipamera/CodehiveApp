package com.example.codehiveapp.ui
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.codehiveapp.modules.RegistrationRequest

import com.example.codehiveapp.viewModel.UserViewModel




class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState:Bundle?) {
       super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnRegister.setClickListener{
            var regRequest=RegistrationRequest(
                name=binding.etName.toString(),
                phoneNumber = binding.etPhoneNumber.toString(),
                email = binding.etEmail.toString(),
                dateOfBirth = binding.etDob.toString(),
                password = binding.etPassword.toString(),
            )

            userViewModel.registerStudent(regRequest)
    }
        userViewModel.registrationLiveData.observe(this,
            { regResponse ->
                if (!regResponse.studentId.isNullOrEmpty()) {

                    Toast.makeText(baseContext, "registration successful", Toast.LENGTH_LONG).show()
                }
        })
        userViewModel.regFailedLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
            })



//    lateinit var etName: EditText
//    lateinit var etDob: EditText
//    lateinit var spNationality: Spinner
//    lateinit var etPhoneNumber: EditText
//    lateinit var etEmail: EditText
//    lateinit var btnRegister: Button
//    lateinit var etPassword: EditText

//        castViews()
//        clickRegister()
    }

//    fun castViews(){
//        etName = findViewById(R.id.etName)
//        etDob  = findViewById(R.id.etDob)
//        spNationality = findViewById(R.id.spNationality)
//        etEmail = findViewById(R.id.etEmail)
//        etPhoneNumber = findViewById(R.id.etPhoneNumber)
//        btnRegister = findViewById(R.id.btnRegister)
//        etPassword = findViewById(R.id.etPassword)

//        val nationality = arrayOf("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
//        var nationalityAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
//        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = nationalityAdapter
//
//    }
//    fun clickRegister(){
//        var error = false
//        btnRegister.setOnClickListener {
//            var name = etName.text.toString()
//            if (name.isEmpty()) {
//                error = true
//                etName.setError("Name is required")
//            }
//
//            var dob = etDob.text.toString()
//            if (dob.isEmpty()) {
//                error = true
//                etDob.setError("Date of birth is required")
//            }
//
//            var tilPassword = etPassword.text.toString()
//            if (tilPassword.isEmpty()) {
//                error = true
//                etPassword.setError("Input password")
//            }
//
//            var nationality = spNationality.selectedItem.toString()
//
//            var email = etEmail.text.toString()
//            if (email.isEmpty()) {
//                error = true
//                etEmail.setError("Email required")
//            }
//
//            var phoneNumber = etPhoneNumber.text.toString()
//            if (phoneNumber.isEmpty()) {
//                error = true
//                etPhoneNumber.setError("Input phone number")
//            }
//
//            var registrationRequest = RegistrationRequest(
//                name = name,
//                phoneNumber = phoneNumber,
//                email = email,
//                dateOfBirth = dob,
//                password = tilPassword
//            )
//
//            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.registerStudent(registrationRequest)
//            request.enqueue(object : Callback<RegistrationResponse> {
//
//                override fun onResponse(
//                    call: Call<RegistrationResponse>,
//                    response: Response<RegistrationResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//
//                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//
//            })
//            val intent = Intent(baseContext, LogIn::class.java)
//            startActivity(intent)
//        }
//}
}
}
//    lateinit var etName: EditText
//    lateinit var etDob: EditText
//    lateinit var spNationality: Spinner
//    lateinit var etPassword: EditText
//    lateinit var etPhone: EditText
//    lateinit var etEmail: EditText
//    lateinit var btnRegister: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        castViews()
//    }
//
//    fun castViews(){
//        etName = findViewById(R.id.etName)
//        etDob = findViewById(R.id.etDoB)
//        spNationality = findViewById(R.id.spNationality)
//        etPassword = findViewById(R.id.tvPassword)
//        etPhone = findViewById(R.id.etPhone)
//        etEmail = findViewById(R.id.etEmail)
//        btnRegister = findViewById(R.id.btnRegister)
//
//        var nationalities = arrayOf("Kenyan", "Rwandan", "South Sudanese", "Sudanese", "Ugandan")
//        var nationalitiesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nationalities)
//        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spNationality.adapter = nationalitiesAdapter
//
//        clickRegister()
//    }
//
//    fun clickRegister(){
//        var error = false
//        btnRegister.setOnClickListener {
//            var name = etName.text.toString()
//            if(name.isEmpty()){
//                error = true
//                etName.setError("Name is required")
//            }
//            var dob = etDob.text.toString()
//            var nationality = spNationality.selectedItem.toString()
//            var password = etPassword.text.toString()
//            var phone = etPhone.text.toString()
//            var email = etEmail.text.toString()
//            if(email.isEmpty()){
//                error=true
//                etEmail.setError("Name is required")
//            }
//
//            var registrationRequest = RegistrationRequest(
//                name=name, phoneNumber=phone, email=email, nationality=nationality,
//                dateOfBirth=dob, password=password
//            )
//
//            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.registerStudent(registrationRequest)
//            request.enqueue(object : Callback<RegistrationResponse> {
//                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
//                    if (response.isSuccessful){
//                        Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
//                    }
//                    else{
//                        try {
//                            val error = JSONObject(response.errorBody()!!.string())
//                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
//                                .show()
//                        } catch (e: Exception) {
//                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
//                        }
//                    }
//                }
//
//                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//            })
//        }
//    }
//}
//
//data class ApiError(var errors: List<String>)

