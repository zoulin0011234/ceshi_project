package sc.tengsem.com.mykotlinonedemo

data class User(val name: String, val imagesUrl: String) {
    private fun getUser(): User {
        return User(name, imagesUrl)
    }
}