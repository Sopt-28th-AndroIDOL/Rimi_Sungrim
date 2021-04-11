# 💚SOPT_28th_Android💚  

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
**Kotlin Extension**이 deprecated됨으로 인해 **ViewBinding** 사용  
기존에 사용하던 ```startActivityForResult```가 deprecated됨으로 인해 새로운 ```registerForActivityResult```메소드 사용  

