from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def helloBabyLion(request): #request 받아서
    #return HttpResponse('장고의 세계로 들어왔습니다.')
    #이렇게 응답이 됨
    return render(request, 'crazyDjango.html')
    #view한테 우리가 만든 template을 사용하라고 알려주는 것