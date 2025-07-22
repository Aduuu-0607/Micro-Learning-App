package com.example.microlearning.Screens.Signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.microlearning.ui.theme.MicroLearningTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.AnnotatedString
import com.example.microlearning.R

@Composable
fun SignUpScreen() {
    val context = LocalContext.current
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var UserName by remember { mutableStateOf("") }
    val backgroundColor = MaterialTheme.colorScheme.background

    val dividerColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.4f) // soft light-gray
    val textColor = MaterialTheme.colorScheme.onSurfaceVariant // auto adjusts to theme


    MicroLearningTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Image(
                    painter = painterResource(id = R.drawable.logo1),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(bottom = 0.dp)
                )

                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.primary, // Adaptive to light/dark
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp
                )


                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = UserName,
                    onValueChange = { UserName = it },
                    label = { Text("User Name") },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp) // ✅ Optional slight margin
                )
                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = emailAddress,
                    onValueChange = { emailAddress = it },
                    label = { Text("Email Address") },
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp) // ✅ Optional slight margin
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        Toast.makeText(context, "Sign Up Clicked", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .padding(horizontal = 18.dp),
                    shape = RoundedCornerShape(30.dp), // Modern rounded button
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF42A5F5), // Light Sky Blue
                        contentColor = Color.White         // White text
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Divider(
                        color = dividerColor,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "OR",
                        color = textColor,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    Divider(
                        color = dividerColor,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )
                }




                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialIcon(R.drawable.google)
                    SocialIcon(R.drawable.facebook)
                    //SocialIcon(R.drawable.ic_twitter)
                }

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Already have an account? ",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Login",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF42A5F5),
                        fontSize = 15.sp,
                        modifier = Modifier.clickable {
                            Toast.makeText(context, "Go to Sign In", Toast.LENGTH_SHORT).show()
                            // navController.navigate("Login") // Uncomment this when navigation is implemented
                        }
                    )
                }
            }


        }
    }
}

@Composable
fun SocialIcon(iconRes: Int) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = null,
        modifier = Modifier
            .size(32.dp)
            .clickable { /* Handle social login */ }
    )
}















