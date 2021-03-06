# ๐SOPT_28th_Android๐  
* [1์ฐจ ์ธ๋ฏธ๋ ๊ณผ์ ](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#1%EC%B0%A8-%EC%84%B8%EB%AF%B8%EB%82%98-%EA%B3%BC%EC%A0%9C)
* [2์ฐจ ์ธ๋ฏธ๋ ๊ณผ์ ](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#2%EC%B0%A8-%EC%84%B8%EB%AF%B8%EB%82%98-%EA%B3%BC%EC%A0%9C)
* [4์ฐจ ์ธ๋ฏธ๋ ๊ณผ์ ](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#4%EC%B0%A8-%EC%84%B8%EB%AF%B8%EB%82%98-%EA%B3%BC%EC%A0%9C)

---
## ๐ค1์ฐจ ์ธ๋ฏธ๋ ๊ณผ์ ๐ค  
### โ ํ์ ๊ณผ์   
### ๐ฒ ๊ตฌํ ํ๋ฉด
<img src="https://user-images.githubusercontent.com/72273531/114294668-14a7f900-9adb-11eb-8ce5-39fcffab2433.gif" width="230" height="500">  


#### โ  ํ๋ฉด ์ ํ ํ ๋ฐ์ดํฐ๋ฅผ ๊ฐ์ ธ์จ ๋ก์ง ์ ๋ฆฌ  
1. *SignInActivity* ์์ ```registerForActivityResult```๋ฅผ ์ฌ์ฉํ์ฌ *SignUpActivity*๋ก ์ด๋ํ๋ค.  
```Kotlin
private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

    }
```
```Kotlin
private fun signUpButtonClickEvent() {
        binding.signInTvSignup.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }
 ```
 
 2. *SignUpActivity*์์ ๊ฐ์ ์๋ ฅ ํ *SIGNUP* ๋ฒํผ์ ๋๋ฅด๋ฉด intent์ *userName, userId, userPw*๋ฅผ ๋ฃ์ด์ฃผ๊ณ  ํด๋น ์กํฐ๋นํฐ๊ฐ ์ข๋ฃ๋๊ฒ ํ์๋ค.  
 ```Kotlin
 private fun signUpButtonClickEvent() {
        binding.signUpBtnSignup.setOnClickListener {
            val userName = binding.signUpEdtName.text
            val userId = binding.signUpEdtId.text
            val userPw = binding.signUpEdtPw.text
            if (userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "๋น ์นธ์ด ์๋์ง ํ์ธํด์ฃผ์ธ์", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("userName", userName)
                intent.putExtra("userId", userId)
                intent.putExtra("userPw", userPw)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
```

#### โก ์๋ช์ฃผ๊ธฐ ํธ์ถ ๋ก๊ทธ ์บก์ฒ ํ๋ฉด  
<img src="https://user-images.githubusercontent.com/72273531/114292890-c5f36280-9acc-11eb-807c-ae7dff3e1557.png" width="600" height="500">

#### โข ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ์ด ๋ด์ฉ ๋ฐ ๊ฐ๋ฐ์๋ก์ ์ฑ์ฅํ ๋ด์ฉ 
1. **Kotlin Extension**์ด deprecated๋จ์ผ๋ก ์ธํด **ViewBinding** ์ฌ์ฉ  
2. ๊ธฐ์กด์ ์ฌ์ฉํ๋ ```startActivityForResult```๊ฐ deprecated๋จ์ผ๋ก ์ธํด ์๋ก์ด ```registerForActivityResult```๋ฉ์๋ ์ฌ์ฉ  



---
## ๐ค2์ฐจ ์ธ๋ฏธ๋ ๊ณผ์ ๐ค  
### โ ํ์ ๊ณผ์   
### ๐ฒ ๊ตฌํ ํ๋ฉด
<img src="https://user-images.githubusercontent.com/72273531/115159377-d196e880-a0cd-11eb-81ee-b6022910f86f.gif" width="230" height="500">  


#### โ  ๊ตฌํ ๋ฐฉ๋ฒ  
1. ๋ฆฌ์ฌ์ดํด๋ฌ๋ทฐ์ ์ฌ์ฉ๋๋ *item_repository.xml* ์์ฑ  
```Kotlin
android:ellipsize="end" 
android:maxLines="1" // ํ์คํธ๊ฐ ๊ธธ์ด์ง ๊ฒฝ์ฐ ํ ์ค๊น์ง๋ง ํ์ํ๊ณ  ๋ ๋ถ๋ถ์ ๋ง์ค์ํ๊ฐ ์ฌ์ฉ๋๋๋ก ํ๋ ์์ฑ
```
2. ๋ฐ์ดํฐ ํด๋์ค *RepositoryInfo.kt* ์์ฑ  
```Kotlin
data class RepositoryInfo(
    val repositoryName: String,
    val repositoryDescription: String,
    val repositoryLanguage: String
)
```
3. *RepositoryAdapter* ์ *RepositoryViewHolder* ์์ฑ  
```Kotlin
class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    val repoList = mutableListOf<RepositoryInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryAdapter.RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RepositoryAdapter.RepositoryViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int  = repoList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    class RepositoryViewHolder(
        private val binding: ItemRepositoryBinding
        ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryInfo: RepositoryInfo){
            binding.homeRepoName.text = repositoryInfo.repositoryName
            binding.homeRepoDescription.text = repositoryInfo.repositoryDescription
            binding.homeRepoLanguage.text = repositoryInfo.repositoryLanguage
        }
    }
}
```
4. *RepositoryAdapter* ์ฐ๊ฒฐ ๋ฐ ๋ฐ์ดํฐ ๊ฐฑ์  
5. *MORE* ๋ฒํผ ์ถ๊ฐ ๋ฐ ํด๋ฆญ ์ด๋ฒคํธ ์์ฑ
```Kotlin
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var repositoryAdapter: RepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moreButtonClickEvent()

        repositoryAdapter = RepositoryAdapter()
        binding.homeRcv.adapter = repositoryAdapter
        repositoryAdapter.repoList.addAll(
            listOf<RepositoryInfo>(
                RepositoryInfo(
                    repositoryName = "Rimi_Sungrim",
                    repositoryDescription = "์ฑ๋ฆผ",
                    repositoryLanguage = "Kotlin"
                ),
                //์๋ต
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

    private fun moreButtonClickEvent() {
        binding.homeClMoreBtn.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
```

---
## ๐ค4์ฐจ ์ธ๋ฏธ๋ ๊ณผ์ ๐ค  
### โ ํ์ ๊ณผ์   
### ๐ฒ ๊ตฌํ ํ๋ฉด
##### ๐ํ์๊ฐ์
<img src="https://user-images.githubusercontent.com/72273531/118396343-12acf900-b68a-11eb-9335-a78ed6232bc5.png" width="900" height="500">  
<img src="https://user-images.githubusercontent.com/72273531/118396405-64ee1a00-b68a-11eb-8072-9e87ef5a6f75.png" width="900" height="500">  
<img src="https://user-images.githubusercontent.com/72273531/118396421-72a39f80-b68a-11eb-939a-11580596c26e.gif" width="230" height="500">  

##### ๐๋ก๊ทธ์ธ
<img src="https://user-images.githubusercontent.com/72273531/118396435-7f27f800-b68a-11eb-8754-b2804e86f14b.png" width="900" height="500">  
<img src="https://user-images.githubusercontent.com/72273531/118396458-97981280-b68a-11eb-83d2-5fb369773463.gif" width="230" height="500">  

#### โ  ์๋ฒํต์  ๋ก์ง ์ ๋ฆฌ  
1. Retrofit Interface ์ค๊ณ  
```Kotlin
interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>

    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUpData
    ) : Call<ResponseSignUpData>
}
```
2. Request, Response ๊ฐ์ฒด ์ค๊ณ  
``` Kotlin
//ํ์๊ฐ์
data class RequestSignUpData(
    val email: String,
    val password: String,
    val sex: String,
    val nickname: String,
    val phone: String,
    val birth: String
)

data class ResponseSignUpData(
    val success: Boolean,
    val message: String,
    val data: Data?
) {
    data class Data(
        val nickname: String
    )
}
```
```Kotlin
//๋ก๊ทธ์ธ
data class RequestLoginData(
    @SerializedName("email")
    val id: String,
    val password: String
)

data class ResponseLoginData(
    val success: Boolean,
    val message: String,
    val data: Data?
) {
    data class Data(
        @SerializedName("UserId")
        val userId: Int,
        val user_nickname: String,
        val token: String
    )
}
```
3. Retrofit Interface ๊ตฌํ์ฒด ์ค๊ณ
```Kotlin
object SoptServiceImpl {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```
4. callback ๋ฑ๋ก
```Kotlin
//ํ์๊ฐ์
val requestSignUpData = RequestSignUpData(
                    email = binding.signUpEdtId.text.toString(),
                    password = binding.signUpEdtPw.text.toString(),
                    sex = "0",
                    nickname = binding.signUpEdtName.text.toString(),
                    phone = "010-1010-2020",
                    birth = "1996-02-24"
                )

                val call: Call<ResponseSignUpData> = SoptServiceImpl.soptService
                    .postSignUp(requestSignUpData)

                call.enqueue(object : Callback<ResponseSignUpData> {
                    override fun onResponse(
                        call: Call<ResponseSignUpData>,
                        response: Response<ResponseSignUpData>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()?.data
                            Toast.makeText(this@SignUpActivity, "${data?.nickname}๋, ๋ฐ๊ฐ์ต๋๋ค >_<", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignUpActivity, "์ด๋ฏธ ์กด์ฌํ๋ ์ด๋ฉ์ผ์๋๋ค", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                        Log.d("NetworkTest", "error:$t")
                    }
                })
```
```Kotlin
//๋ก๊ทธ์ธ
val requestLoginData = RequestLoginData(
                id = binding.signInEdtId.text.toString(),
                password = binding.signInEdtPw.text.toString()
            )

            val call: Call<ResponseLoginData> = SoptServiceImpl.soptService
                .postLogin(requestLoginData)

            call.enqueue(object : Callback<ResponseLoginData> {
                override fun onResponse(
                    call: Call<ResponseLoginData>,
                    response: Response<ResponseLoginData>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()?.data
                        Toast.makeText(this@SignInActivity, "${data?.user_nickname}๋, ๋ก๊ทธ์ธ ์ฑ๊ณต", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "์์ด๋ ๋๋ ๋น๋ฐ๋ฒํธ๋ฅผ ํ์ธํด ์ฃผ์ธ์.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    Log.d("NetworkTest", "error:$t")
                }
            })
```


#### โก ๊ณผ์ ๋ฅผ ํตํด ๋ฐฐ์ด ๋ด์ฉ ๋ฐ ๊ฐ๋ฐ์๋ก์ ์ฑ์ฅํ ๋ด์ฉ 
1. ์๋ฒํต์ ํ๋ ์๋ฆฌ๋ฅผ ์ ์ดํดํ  ์ ์๊ฒ ๋์๋ค.  
2. json์ ๋ฐ์ดํฐ ํด๋์ค๋ก ์ฝ๊ฒ ๋ฐ๊ฟ ์ ์๋ plugin์ ์๊ฒ ๋์๋ค. (ํ์ฐ๋ ์ต๊ณ )  
