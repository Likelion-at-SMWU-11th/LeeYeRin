from django.shortcuts import render
from django.http import HttpResponse, JsonResponse

from django.views.generic import ListView
from .models import Post

import random
# Create your views here.

def index(request):
    return render(request, 'index.html')

def post_list_view(request):
    return render(request, 'posts/post_list.html')

def post_detail_view(request, id):
    return render(request, 'posts/post_detail.html')

def post_create_view(request):
    return render(request, 'posts/post_form.html')

def post_delete_view(request, id):
    return render(request, 'posts/post_confirm_delete.html')

def url_view(request):
    data = {'code': '001', 'msg': 'OK'}
    return HttpResponse('<h1>url_views</h1>')
    # return JsonResponse(data)

def url_parameter_view(request, username):
    print('url_parameter_view()')
    print(f'username: {username}')
    print(f'request.GET: {request.GET}')
    return HttpResponse(username)

class class_view(ListView):
    model = Posttemplate_name = 'cbv_view.html' 

def function_view(request):
    print(f'request.method: {request.method}')

    if request.method == "GET":
        print(f'request.GET: {request.GET}')
    elif request.method == "POST":
        print(f'request.POST: {request.POST}')
    return render(request, 'view.html')

def lotto(request):
    lotto_nubmer = list()
    for _ in range(7):
        lotto_nubmer.append(random.randint(1, 45))
    return render(request, 'lotto.html', {'lotto_number' : lotto_nubmer})

def lotto_index(request):
    return render(request, 'lotto_index.html')

def lotto_result(request):
    lotto_number = list()
    game = request.GET.get('game', 1)
    pull_number = [index for index in range(1, 46)]
    
    for _ in range(int(game)):
        lotto_number.append(random.sample(pull_number, 6))
        
    return render(request, 'lotto_result.html', {'lotto_number' : lotto_number, 'game' : game})