package be.ehb.gdt.recipeify.utility

import android.content.Context
import android.util.Log
import be.ehb.gdt.recipeify.models.Recipe
import be.ehb.gdt.recipeify.models.dtomodels.RecipeDto
import be.ehb.gdt.recipeify.ui.home.HomeFragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class RecipeRepository(context: Context) {
    private val queue: RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }
    private val url = "https://www.themealdb.com/api/json/v1/1"

    fun getRandomRecipe() {
        val request = StringRequest(Request.Method.GET, "$url/random.php",
            { Log.d(javaClass.simpleName, it) },
            {e -> Log.d(javaClass.simpleName, e.message!!) }
        )
        queue.add(request)
    }

    companion object{
        @Volatile
        private var INSTANCE: RecipeRepository? = null
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RecipeRepository(context).also {
                    INSTANCE = it
                }
            }
    }

    fun transformRecipe(dto: RecipeDto) : Recipe {
        val ingredients = mutableMapOf<String, String>();
        ingredients[dto.strIngredient1] = dto.strMeasure1
        ingredients[dto.strIngredient2] = dto.strMeasure2
        ingredients[dto.strIngredient3] = dto.strMeasure3
        ingredients[dto.strIngredient4] = dto.strMeasure4
        ingredients[dto.strIngredient5] = dto.strMeasure5
        ingredients[dto.strIngredient6] = dto.strMeasure6
        ingredients[dto.strIngredient7] = dto.strMeasure7
        ingredients[dto.strIngredient8] = dto.strMeasure8
        ingredients[dto.strIngredient9] = dto.strMeasure9
        ingredients[dto.strIngredient10] = dto.strMeasure10
        ingredients[dto.strIngredient11] = dto.strMeasure11
        ingredients[dto.strIngredient12] = dto.strMeasure12
        ingredients[dto.strIngredient13] = dto.strMeasure13
        ingredients[dto.strIngredient14] = dto.strMeasure14
        ingredients[dto.strIngredient15] = dto.strMeasure15
        ingredients[dto.strIngredient16] = dto.strMeasure16
        ingredients[dto.strIngredient17] = dto.strMeasure17
        ingredients[dto.strIngredient18] = dto.strMeasure18
        ingredients[dto.strIngredient19] = dto.strMeasure19
        ingredients[dto.strIngredient20] = dto.strMeasure20
        return Recipe(
            dto.idMeal,
            dto.strMeal,
            dto.strCategory,
            dto.strArea,
            dto.strInstructions,
            dto.strMealThumb,
            ingredients
        )
    }
}