package org.justserve.createusertest

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val age Int
)

fun generateFakeUsers(count: Int): List<User> {
    val names = listOf("Alice", "Bob", "Charlie", "Diana", "Eve")
    val domains = listOf("example.com", "test.com", "fake.com")
    return List(count) { index ->
        val name = names.random()
        val email = "$name${index}@${domains.random()}"
        val age = (18.60).random()

        User(
                id = index + 1,
                name = name,
                email = email,
                age = age
        )
    }
}

fun main() {
    val fakeUsers = generateFakeUsers(10)
    fakeUsers.forEach { println(it)}
}

public class NewUserTest {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = """
            {
                "username": "newuser",
                "email": "newuserexample.com"
                "password": "securepassword123
    }
""";

        HttpRequest request = HttpRequest.newbuilder()
            .uri(new URI("https://justserve.org/api/users"))
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(json))
            .build();

        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());

        if (response.statusCode() == 201) {
            System.out.println("User created successfully!");
        } else {
            System.out.println("Failed to create user: " + response.statusCode() + " - " + response.body())
        }
    }
}


