package com.route.e_commercec40gsunwed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp





class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignUpPreview()
        }
    }
}



@Composable
fun SignUp(modifier: Modifier = Modifier) {
    // State to hold the text field value
    var fullNameTextField by remember { mutableStateOf(TextFieldValue("")) }
    var mobileNumberTextField by remember { mutableStateOf(TextFieldValue("")) }
    var emailAddressTextField by remember { mutableStateOf(TextFieldValue("")) }
    var passwordTextField by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by remember { mutableStateOf(false) }



    var fullNameError by remember { mutableStateOf("") }
    var mobileNumberError by remember { mutableStateOf("") }
    var emailAddressError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }



    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0, 65, 130, 255))
            .padding(start = 18.dp, end = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image logo
            Image(
                painter = painterResource(id = R.drawable.route_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(71.dp)
                    .width(237.dp),
                contentScale = ContentScale.FillWidth
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.Start
            ) {

                // Full Name
                Text(text = "Full Name", color = Color.White, fontSize = 16.sp)
                CustomTextField(
                    value = fullNameTextField,
                    onValueChange = { fullNameTextField = it },
                    label = "Full Name",
                    error = fullNameError,
                    onErrorChange = { fullNameError = it }

                )

                // Mobile Number
                Text(text = "Mobile Number", color = Color.White, fontSize = 16.sp)
                CustomTextField(
                    value = mobileNumberTextField,
                    onValueChange = { mobileNumberTextField = it },
                    label = "Mobile Number",
                    error = mobileNumberError,
                    onErrorChange = { mobileNumberError = it }
                )

                // E-mail address
                Text(text = "E-mail address", color = Color.White, fontSize = 16.sp)
                CustomTextField(
                    value = emailAddressTextField,
                    onValueChange = { emailAddressTextField = it },
                    label = "E-mail address",
                    error = emailAddressError,
                    onErrorChange = { emailAddressError = it }
                )

                // Password
                Text(text = "Password", color = Color.White, fontSize = 16.sp)
                CustomTextField(
                    value = passwordTextField,
                    onValueChange = { passwordTextField = it },
                    label = "Password",
                    error = passwordError,
                    onErrorChange = { passwordError = it },
                    isPasswordField = true,
                    passwordVisible = passwordVisible,
                    onPasswordVisibilityChange = { passwordVisible = it }
                )



                Button(
                    onClick = {

                        fullNameError = if (fullNameTextField.text.isEmpty()) "Required !" else ""
                        mobileNumberError = if (mobileNumberTextField.text.isEmpty()) "Required !" else ""
                        emailAddressError = if (emailAddressTextField.text.isEmpty()) "Required !" else ""
                        passwordError = if (passwordTextField.text.isEmpty()) "Required !" else ""
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)

                        .background(Color.White, shape = RoundedCornerShape(15.dp))
                        .padding(8.dp)

                    ,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0, 65, 130, 255),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}





@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    error: String,
    onErrorChange: (String) -> Unit,
    isPasswordField: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: (Boolean) -> Unit = {}
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White),
            placeholder = { Text(text = "Enter your $label", color = Color.Gray) },
            visualTransformation = if (isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            suffix = if (isPasswordField) {
                {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        modifier = Modifier.clickable { onPasswordVisibilityChange(!passwordVisible) }
                    )
                }
            } else null
        )
        if (error.isNotEmpty()) {
            Text(text = error, color = Color.Red, fontSize = 12.sp)
        }
    }
}



@Preview(showSystemUi = true)
@Composable
private fun SignUpPreview() {

    SignUp()

}
