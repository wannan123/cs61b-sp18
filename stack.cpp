#include<iostream>
#define N 100
#include<cstdlib> 
using namespace std;

typedef struct {
	int *top,*base;
	int max_size;
}Stack;

void Stack_init(Stack &S)
{
	S.base=new int[N];
	if (S.base==NULL){
		cout<<"��ʼ��ʧ��";
		exit(0);
	}
	S.top=S.base;
	S.max_size=N;
}
int empty(const Stack &S)
{
	if(S.base==S.top){
		return 0;
	}return 1;
}
int Stacklength(const Stack &S)
{
	return S.top-S.base;
}
void clear(Stack &S)
{
	if(S.base){
		S.top=S.base;
	}
}
void destory(Stack &S)
{
	S.base=0;
	S.top=0;
	delete []S.base;
	S.max_size=0;
}
void insert(Stack &S,int n)
{
	if(S.top-S.base<S.max_size){
		*S.top=n;
		S.top++;
		
	}else{
		cout<<"ջ��";
		exit(0); 
	}
}
int pop(Stack &S)
{	
	if(S.top==S.base){
		cout<<"ջ���";
		exit(0); 
	}
	return *--S.top;
} 

int main()
{
	int n;
	Stack S;
	Stack_init(S);
	insert(S,2);
	cout<<"����������Ҫѹ��ջ��������"<<endl;
	cin>>n;
	cout<<"�������������"<<endl; 
	for(int i=0;i<n;i++){
		int j;
		cin>>j;
		insert(S,j);
	}
	cout<<"������ѹ��ջ�����֣�"<<endl;
	for (int i=0;i<n;i++){
		int k=pop(S);
		cout<<k<<endl;
	} destory(S);
	return 0;
}
