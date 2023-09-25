# LeeYeRin
숙명여대 멋사 아기사자 이예린🦁

|번호|실습화면|
|------|---|
|17-18|<img width="757" alt="#17" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/6072f895-2190-4328-a296-9713d93776b4">|
|19-20|<img width="753" alt="#19" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/623c4caa-7e95-4541-824f-14c44edea4a6">|
|21-22|<img width="754" alt="#21" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/a267ee68-611b-445b-9c38-36b4a8d89db0">|
|23|<img width="755" alt="23" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/cc4f387a-0a05-41b9-af9b-c757f858a441">|
|24-1|<img width="755" alt="24-1" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/a7616fb2-7a04-4979-99e6-2282a75da3fe">|
|24-2|<img width="752" alt="24-2" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/b508538a-440c-4e5f-be4f-779d68d2e17c">|
|24-3|<img width="752" alt="24-3" src="https://github.com/Likelion-at-SMWU-11th/LeeYeRin/assets/83818069/ca4d9d51-dd1b-4df3-bf45-47b360b98173">|

<br>

# 2차 세미나 : 스프링 JPA 구조에 대한 보고서 작성하기

![스크린샷 2023-09-20 오전 3.36.45.png](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbaBzhdEZKzBcu5NiUQiiE8HszxjCZxDQoZhORYsifHAmSdRWMb_Hjlj_WwIlgWezhbc0&usqp=CAU)

# 각 계층의 기능과 역할

## Controller (Web)

- 해당 요청 url에 따라 적절한 view와 mapping을 처리한다.
- `@Autowired Service`를 통해 service의 method를 이용한다. (사용자의 입력을 받고 서비스로 전달하는 역할)
- 적절한 DTO를 담아서 Client에게 전달한다.

 **@Controller vs @RestController 비교**

`@Controller`

- API와 view를 동시에 사용하는 경우 사용한다.
- 만약, API 서비스로 사용하는 경우 `@ResponseBody`를 사용하여 객체를 반환한다.
- view(화면) return이 주 목적이다.

`@RestController`

- view가 필요없고 API만 지원하는 서비스에서 주로 사용한다.
- `@RequestMapping` 메서드가 기본적으로 `@ResponseBody` 의미를 가정한다.
- data (json, xml 등) return 이 주목적일 때는 return 타입이 `ResponseEntity`이다.
- `@RestController = @Controller + @ResponseBody`

## Service

- 핵심 비즈니스 로직을 수행한다.
    - ex) 중복 아이디가 있는지 없는지를 검사하기 위한 일련의 과정들
    - 어떻게 데이터가 생성, 저장, 수정, 삭제, 조회 등 되는 지를 정의한 것
    - **DAO(repository)로 DB에 접근하고 DTO로 데이터를 전달받은 다음, 비즈니스 로직을 처리해 적절한 데이터를 반환한다.**
- `@Autowired Repository`를 통해 repository의 method를 이용한다.

## Repository

- Entity에 의해 생성된 데이터베이스에 접근하는 메소드를 사용하기 위한 인터페이스이다.
- Service와 DB를 연결하는 고리의 역할을 수행한다.
- 데이터베이스에 적용하고자 하는 CRUD를 정의하는 영역이다.

## DAO (Data Access Object)

- 실제로 데이터베이스에 접근하는 객체를 의미한다. (Persistance Layer)
- Service가 DB에 연결할 수 있게 해주는 역할을 한다.
- DB를 사용하여 데이터를 조회하거나 조작하는 기능을 전달한다.

## DTO (Data Transfer Object)

- 계층 간 데이터 교환을 위한 객체를 의미한다. (Java Beans)
- DTO는 VO(value Object)로 불리기도 하며,
    - DB에서 데이터를 얻어 Service나 Controller 등으로 보낼 때 사용하는 객체
    - **로직을 갖고 있지 않은 순수한 데이터 객체, `getter/setter` 메서드만을 갖는다.**
    - 하지만, **DB에서 꺼낸 값을 임의로 변경할 필요가 없기 때문에 DTO클래스에는 `setter`가 없다.** (대신, 생성자에서 값을 할당한다.)
- **VO(Value Object) vs DTO**
    - VO는 DTO와 동일한 개념이지만 read only 속성을 갖는다.
    - **VO는 특정한 비즈니스 값을 담는 객체, DTO는 Layer간의 통신 용도로 오고가는 객체**

## Entity (Domain)

- 실제 DB의 테이블과 매칭될 클래스
    - 데이터베이스의 테이블을 하나의 엔티티로 생각해도 무방함
    - 실제 데이터베이스의 테이블과 1:1 매핑됨
    - 이 클래스의 필드는 각 테이블 내부의 컬럼(Column)을 의미
    - `@Entity`, `@Column`, `@Id` 등을 이용한다.
- Entity 클래스와 DTO 클래스를 분리하는 이유
    - View Layer와 DB Layer의 역할을 분리하기 위해서 사용
    - **테이블과 매핑되는 Entity 클래스가 변경되면 여러 클래스에 영향을 준다.**
    - **View와 통신하는 DTO 클래스(Request, Response 클래스)는 자주 변경되므로 분리해야 한다.**

# DTO를 사용하는 이유

### 관심사의 분리 (Seperation of Concerns, SoC)

`도메인 모델`은 Data Access 계층에서 데이터가 저장되는 `DB`와 직접적으로 관련되어 있는 객체다.

테이블의 구조에 맞게 설계되는 도메인 모델은 초기 설계 후 되도록 최대한 수정되지 않는 것이 안정적인 모델이다.

그에 반해 Presentation 계층에서는 View의 요구 사항에 따라 전달되는 데이터의 구조가 자주 바뀔 수 있다.

게다가 도메인 모델은 View에 노출되면 안되는 민감한 정보들도 가지고 있으므로, 이 객체를 View에 전달해서는 안된다.

이는 각 계층의 관심사가 달라서 생기는 차이다.

- `Presentation Layer` : 애플리케이션의 기능과 데이터를 사용자에게 제공
- `Business Layer` : 애플리케이션의 핵심 비즈니스 로직 및 나머지 두 계층 간에 전달되는 데이터 처리
- `Data Access Layer` : 데이터베이스와 상호 작용하는 역할

![Untitled](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi0MT2BUh8DozpEBXkrcxAcprYAfIF8azFaw&usqp=CAU)

각 계층의 관심사에 맞게 데이터를 담는 객체도 구분을 지어줘야 한다. 이를 객체 지향에서는 `관심사의 분리(Seperation of Concerns, SoC)`라 한다.

- **DTO**
    - 데이터의 전달
    - Presentation Layer에 속함
- **Entity (Domain)**
    - 핵심 비즈니스 로직을 담는 비즈니스 도메인의 영역의 일부
    - 그에 따른 비즈니스 로직이 추가될 수 있음
    - Presentation 계층에 속함
