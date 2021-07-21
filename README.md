# 💚SOPT_28th_Android💚  
* [1차 세미나 과제](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#1%EC%B0%A8-%EC%84%B8%EB%AF%B8%EB%82%98-%EA%B3%BC%EC%A0%9C)
* [2차 세미나 과제](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#2%EC%B0%A8-%EC%84%B8%EB%AF%B8%EB%82%98-%EA%B3%BC%EC%A0%9C)
* [4차 세미나 과제](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#4%EC%B0%A8-%EC%84%B8%EB%AF%B8%EB%82%98-%EA%B3%BC%EC%A0%9C)

---
## 🤍1차 세미나 과제🤍  
### ✅ 필수 과제  
### 📲 구현 화면
<img src="https://user-images.githubusercontent.com/72273531/114294668-14a7f900-9adb-11eb-8ce5-39fcffab2433.gif" width="230" height="500">  


#### ① 화면 전환 후 데이터를 가져온 로직 정리  
1. *SignInActivity* 에서 ```registerForActivityResult```를 사용하여 *SignUpActivity*로 이동한다.  
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
 
 2. *SignUpActivity*에서 값을 입력 후 *SIGNUP* 버튼을 누르면 intent에 *userName, userId, userPw*를 넣어주고 해당 액티비티가 종료되게 하였다.  
 ```Kotlin
 private fun signUpButtonClickEvent() {
        binding.signUpBtnSignup.setOnClickListener {
            val userName = binding.signUpEdtName.text
            val userId = binding.signUpEdtId.text
            val userPw = binding.signUpEdtPw.text
            if (userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
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

#### ② 생명주기 호출 로그 캡처 화면  
<img src="https://user-images.githubusercontent.com/72273531/114292890-c5f36280-9acc-11eb-807c-ae7dff3e1557.png" width="600" height="500">

#### ③ 과제를 통해 배운 내용 및 개발자로서 성장한 내용 
1. **Kotlin Extension**이 deprecated됨으로 인해 **ViewBinding** 사용  
2. 기존에 사용하던 ```startActivityForResult```가 deprecated됨으로 인해 새로운 ```registerForActivityResult```메소드 사용  



---
## 🤍2차 세미나 과제🤍  
### ✅ 필수 과제  
### 📲 구현 화면
<img src="https://user-images.githubusercontent.com/72273531/115159377-d196e880-a0cd-11eb-81ee-b6022910f86f.gif" width="230" height="500">  


#### ① 구현 방법  
1. 리사이클러뷰에 사용되는 *item_repository.xml* 생성  
```Kotlin
android:ellipsize="end" 
android:maxLines="1" // 텍스트가 길어질 경우 한 줄까지만 표시하고 끝 부분에 말줄임표가 사용되도록 하는 속성
```
2. 데이터 클래스 *RepositoryInfo.kt* 생성  
```Kotlin
data class RepositoryInfo(
    val repositoryName: String,
    val repositoryDescription: String,
    val repositoryLanguage: String
)
```
3. *RepositoryAdapter* 와 *RepositoryViewHolder* 생성  
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
4. *RepositoryAdapter* 연결 및 데이터 갱신 
5. *MORE* 버튼 추가 및 클릭 이벤트 생성
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
                    repositoryDescription = "성림",
                    repositoryLanguage = "Kotlin"
                ),
                //생략
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
## 🤍4차 세미나 과제🤍  
### ✅ 필수 과제  
### 📲 구현 화면
##### 📌회원가입
<img src="https://user-images.githubusercontent.com/72273531/118396343-12acf900-b68a-11eb-9335-a78ed6232bc5.png" width="900" height="500">  
<img src="https://user-images.githubusercontent.com/72273531/118396405-64ee1a00-b68a-11eb-8072-9e87ef5a6f75.png" width="900" height="500">  
<img src="https://user-images.githubusercontent.com/72273531/118396421-72a39f80-b68a-11eb-939a-11580596c26e.gif" width="230" height="500">  

##### 📌로그인
<img src="https://user-images.githubusercontent.com/72273531/118396435-7f27f800-b68a-11eb-8754-b2804e86f14b.png" width="900" height="500">  
<img src="https://user-images.githubusercontent.com/72273531/118396458-97981280-b68a-11eb-83d2-5fb369773463.gif" width="230" height="500">  

#### ① 서버통신 로직 정리  
1. Retrofit Interface 설계  
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
2. Request, Response 객체 설계  
``` Kotlin
//회원가입
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
//로그인
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
3. Retrofit Interface 구현체 설계
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
4. callback 등록
```Kotlin
//회원가입
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
                            Toast.makeText(this@SignUpActivity, "${data?.nickname}님, 반갑습니다 >_<", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignUpActivity, "이미 존재하는 이메일입니다", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                        Log.d("NetworkTest", "error:$t")
                    }
                })
```
```Kotlin
//로그인
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
                        Toast.makeText(this@SignInActivity, "${data?.user_nickname}님, 로그인 성공", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "아이디 또는 비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    Log.d("NetworkTest", "error:$t")
                }
            })
```


#### ② 과제를 통해 배운 내용 및 개발자로서 성장한 내용 
1. 서버통신하는 원리를 잘 이해할 수 있게 되었다.  
2. json을 데이터 클래스로 쉽게 바꿀 수 있는 plugin을 알게 되었다. (현우님 최고)  
