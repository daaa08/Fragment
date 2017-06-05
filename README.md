## Fragment
- 하나의 Activity에 창이 여러개인 UI구축 
- 하나의 Fragment를 여러 Activity에서 재사용 가능
- 자체 생명 주기를 가지고 있음 (액티비티 실행 중에 추가 및 제거가 가능)
- 항상 Activity내에 포함되어있어야 함
- CallBack 메소드가 사용됨 
(피호출자가 호출자를 호출하는 것, 비동기적으로 사용 가능)

![enter image description here](https://developer.android.com/images/fundamentals/fragments.png?hl=ko)

> Transaction
> - 상태를 변화시키기 위해서 수행하는 단위
> - 작업 처리 결과가 항상 일관성 있어야 함 ( 추가,삭제들이 일괄적으로 수행되어야 함)
> - 둘 이상의 Transaction이 실행중일 경우 다른 Transaction에 껴들 수 없음

## FragmentTransaction

```java
  // 1 프래그먼트 트랜잭션 가져오기 
  FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
  // 2 화면에 프래그먼트 넣기 - Fragment를 추가하려면 add()를 사용해야 함
  transaction.add(R.id.container, list);
  // 3 트랜젝션 완료 - commit()을 호출해야 변경 내용이 적용 됨 
  transaction.commit();  
```

## addToBackStack
- Transaction이 commit()된 후 기억되는 것으로 stack에서 pop될때 역으로 작동
```java
FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
transaction.add(R.id.container, detail);
// 트랜젝션 처리 전체를 스택에 담아놨다가 안드로이드의 백 버튼으로 뒤로가기를 할 수 있다
transaction.addToBackStack(null);
transaction.commit();
```
