# Star Between Coding Convention

Star Between 은 프로젝트 진행에 있어 일관적인 코딩 컨벤션을 가지고 있습니다.
최대한 주의하여 주시고, 테스트용 코드를 작성 할 시에도 최대한 규칙을 지킬 수 있도록 노력해주십시오.

## 변수 네이밍에 관해
변수를 네이밍 할때 지켜야 할 기본적인 3가지 원칙은 명사, CamelCase 그리고 축약을 하지 않는 것 입니다.

- 명사가 아닌 변수는 쉽게 와닿지 않습니다. 만일 구체적으로 표현하고 싶으면 형용사 격을 붙여주세요
- 해당 프로젝트에서는 [CamelCase 표기법](http://zetawiki.com/wiki/%EC%B9%B4%EB%A9%9C%ED%91%9C%EA%B8%B0%EB%B2%95_camelCase,_%ED%8C%8C%EC%8A%A4%EC%B9%BC%ED%91%9C%EA%B8%B0%EB%B2%95_PascalCase#.EC.B9.B4.EB.A9.9C_.ED.91.9C.EA.B8.B0.EB.B2.95)을 사용합니다.
- 변수를 네이밍 할때 최대한 축약을 하지 않습니다. 예를들어 동의를 누르는 버튼의 이름은 acceptBtn가 아니라 acceptButton이 됩니다.
  - 단 클래스가 두개 이상의 단어로 연결되어 있는경우, 필요한 부분(명사구)로 축약할 수는 있습니다.
    - Main부분에서 쓰이는 LinerLayout을 굳이 mainLinerLayout으로 할 필요는 없습니다. 이는 mainLayout으로도 충분히 의미가 전달됩니다.

위의 네이밍 규칙을 지키기 힘든 상황에는, 임의로 진행한 뒤 주석을 달아주세요.

또한 자주 사용되는 특정 View에는 클래스 네임과 별개로 붙는 이름이 있습니다.
- EditText = Field
  - id를 입력하는 EditText의 경우 idField
- TextView = Label
  - email을 표시하는 TextView의 경우 emailLabel

또한 값을 복사하거나 임시값을 쓰는 경우도 어떤 변수에 대한 복사값인지, 임시값인지 정도는 판별할 수 있게끔 합니다.
- userInfoCopy
- userTemp

또한 데이터의 집합(컬렉션)을 쓸때는 명사의 복수형을 사용합니다.
- List<User> users;
- User[] users;
> 길이가 가변적인 경우에는 반드시 List등의 동적인 컬렉션을 씁니다. 변수가 초기화 되고나서 절대 길이가 변하지 않으면 배열을 씁니다.

#### 멤버 필드와 네이밍에 관해
멤버 필드를 네이밍 할때는 반드시 변수명의 가장 앞에 m을 붙입니다.

#### 지역변수와 네이밍에 관해
지역 변수를 네이밍 할때는 앞에 접두어를 붙이지 않고, CamelCase를 따릅니다.
> 패러미터(메소드 인자)도 지역변수로 취급합니다.

#### 전역변수와 네이밍에 관해
전역 변수를 네이밍 할때는 두가지 경우가 있습니다.
- final 키워드와 함께 전역 상수로서 사용될 경우(주로 버전이나 지정값 등)
  - CamelCase를 따르지 않고 전부 대문자로 표기합니다, 띄어쓰기가 필요할 경우는 _ 로 대체합니다.
    - public static final int SDK_VERSION = 3;
- 하나의 클래스에서 객체들이 값을 공유하는 경우
  - 맨 앞에 접두어로 s를 붙입니다.
    - private static Object sSharedObject;

## 함수 네이밍에 관해
함수를 네이밍 할때에는 될수 있으면 동사구가 되게끔 하는것을 권장합니다. 하지만 이에대해서 강제하지는 않습니다.

## 클래스 네이밍에 관해
클래스는 어떤 클래스를 상속받는지, 어떤 역할을 하는지 한눈에 알 수 있도록 명확하게 작성해 주십시오.

## 리스너 생성에 대해
절대 Activity나 Fragment에 응하는 클래스에 implements하지 않습니다. 일회용인 경우는 익명객체로, 그 로직이 20라인이 넘어갈경우 리스러를 InnerClass로 만들어 주십시오.

재사용의 여지가 큰 경우는 아예 클래스로 분리해주십시오.

## 접근 지정자에 대해
접근 지정자는 '남에게 보여지는', '남이 사용해야하는', '남이 바꿀 수 있는' 경우에만 public를 허용합니다. 그 외에는 private로, 상속이 필요한경우는 protect로 선언해 주십시오

단 필드에 대해서는 public를 허용하지 않습니다. 반드시 getter를, 필요한 경우는 setter를 생성해주십시오

## 콤마(,)에 대해
패러매터 등에서 ','를 쓸 경우 반드시 ','는  앞 문자에 붙여쓰기 해야하며, 뒷 문자에 띄워쓰기 해주십시오.
```
public void StartWithOptions(String name, String email, int version)
```
## 연산자에 대해
연산자를 사용할 시에는 앞, 뒤에 뛰어쓰기를 해주십시오.
```
int a = 3+2;  // Bad
int a= 3 + 2  // Bad
int a = 3 + 2 // good
```
## 중괄호에 대해
중괄호에 대한 규약은 예시로 대체합니다.
```
//중괄호의 개시는 앞 문자에 대한 띄워쓰기와 함께 붙습니다. 즉 개행하지 않습니다.
if (version == MIN_SDK) {

}
```
## 패러미터가 너무 길어짐에 대해
패러미터의 개수가 너무 많아져 줄내림이 필요할 경우에는, 내려진 줄의 패러미터 자료형 앞에 ,가 위치하게끔 해주십시오.
```
//해당 예시는 좋은 예시가 아닙니다, 본래 이런경우에는 Option용 클래스를 선언해 주는 것이 좋습니다.
public void StartWithOptions(String name, String email, int version
                                , float temp, int etc) {
    //body
}
```
