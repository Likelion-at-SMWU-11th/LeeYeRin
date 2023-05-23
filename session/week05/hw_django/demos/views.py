from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.

def helloPage(request):
    return render(request, 'study.html')