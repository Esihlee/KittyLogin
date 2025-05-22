package com.example.kittylogin.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kittylogin.model.User
import com.example.kittylogin.viewModel.UserViewModel

private val OrangeColor = Color(0xFFFF9800)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayScreen(navController: NavController, userViewModel: UserViewModel) {
    LaunchedEffect(Unit) {
        userViewModel.fetchAllUsers()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("All Registered Users") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black  // Make arrow white for contrast
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = OrangeColor
                )
            )
        }
    ) { paddingValues ->

        val users = userViewModel.userList

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(users) { user ->
                UserItem(user)
                Divider()
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    // Card with orange border
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        border = BorderStroke(2.dp, OrangeColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Student Number: ${user.studentNumber}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Name: ${user.name} ${user.surname}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
