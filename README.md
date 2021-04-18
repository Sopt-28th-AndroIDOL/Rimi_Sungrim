# 💚SOPT_28th_Android💚  
* [1차 세미나 과제](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#-%ED%95%84%EC%88%98-%EA%B3%BC%EC%A0%9C)
* [2차 세미나 과제](https://github.com/Sopt-28th-AndroIDOL/Rimi_Sungrim/blob/main/README.md#-%ED%95%84%EC%88%98-%EA%B3%BC%EC%A0%9C)

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
4. *RepositoryAdapter* 연결 및 데이터 갱신 & 5. MORE 버튼 추가 및 클릭 이벤트 생성
```
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
