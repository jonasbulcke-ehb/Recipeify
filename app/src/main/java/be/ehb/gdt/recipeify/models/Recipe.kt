package be.ehb.gdt.recipeify.models

data class Recipe(
    val id: Int,
    val name: String,
    val category: String,
    val area: String,
    val instructions: String,
    val thumbnail: String,
    val ingredients: Map<String, String>
)
