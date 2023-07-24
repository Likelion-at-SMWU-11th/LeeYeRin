from django.shortcuts import render

from django.http import HttpResponse, JsonResponse

from django.views.generic import ListView
from .models import article

def index(request):
    return render(request, 'index.html')

def article_list_view(request):
    return render(request, 'article/article_list.html')

def article_detail_view(request, id):
    return render(request, 'article/article_detail.html')

def article_create_view(request):
    return render(request, 'article/article_form.html')

def article_delete_view(request, id):
    return render(request, 'article/article_confirm_delete.html')

def url_view(request):
    data = {'code': '001', 'msg': 'OK'}
    return JsonResponse(data)
    # return HttpResponse('<h1>url_view</h1>')
    
def url_parameter_view(request, username):
    print('url_parameter_view()')
    print(f'username: {username}')
    print(f'request.GET: {request.GET}')
    return HttpResponse(username)

def function_view(request):
    print(f'request.method: {request.method}')
    
    if request.method == "GET":
        print(f'request.GET: {request.GET}')
    elif request.method == "POST":
        print(f'request.POST: {request.POST}')
    return render(request, 'view.html')

class class_view(ListView):
    model = article
    template_name = 'cbv_view.html'