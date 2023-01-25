from django.shortcuts import render
from .forms import AddStudentForm, AddProfessorForm
from django.http.response import JsonResponse

from .models import Student, Professor
from .serializers import StudentSerializer, ProfessorSerializer
import requests
from django.http import HttpResponse


# Create your views here.
def index(request):
    return render(request, 'pmfservice/index.html')


def add_student(request):
    try:
        if request.method == 'GET':
            student_form = AddStudentForm()
        else:
            student_form = AddStudentForm(request.POST)
            if student_form.is_valid():
                student_id = student_form.cleaned_data['id']
                student_name = student_form.cleaned_data['name']
                student_surname = student_form.cleaned_data['surname']
                student_index = student_form.cleaned_data['index']
                student_faculty = 'ftn'
                student, _ = Student.objects.get_or_create(id=student_id, name=student_name, surname=student_surname,
                                                           index=student_index, faculty=student_faculty)

                body = JsonResponse(StudentSerializer(student).data)
                response = requests.post("http://localhost:8080/students", headers={
                    'Content-Type': 'application/json',
                    'Accept-Encoding': 'gzip.deflate.br',
                    'Connection': 'keep-alive'
                }, data=body)

                if response.text == 'CREATED':
                    student_form.save()
                    return HttpResponse('Student is successfully saved!')
                else:
                    return HttpResponse('Student already exists!')
        return render(request, 'pmfservice/add-student.html', {
            'form': student_form
        })
    except Exception as e:
        return render(request, 'pmfservice/add-student.html')


def add_professor(request):
    try:
        if request.method == 'GET':
            professor_form = AddProfessorForm()
        else:
            professor_form = AddProfessorForm(request.POST)
            if professor_form.is_valid():
                professor_id = professor_form.cleaned_data['id']
                professor_name = professor_form.cleaned_data['name']
                professor_surname = professor_form.cleaned_data['surname']
                professor_faculty = 'ftn'
                professor_email = professor_form.cleaned_data['email']
                professor, _ = Professor.objects.get_or_create(id=professor_id, name=professor_name,
                                                               surname=professor_surname, faculty=professor_faculty,
                                                               email=professor_email)

                body = JsonResponse(ProfessorSerializer(professor).data)
                response = requests.post("http://localhost:8080/professors", headers={
                    'Content-Type': 'application/json',
                    'Accept-Encoding': 'gzip.deflate.br',
                    'Connection': 'keep-alive'
                }, data=body)

                if response.text == 'CREATED':
                    professor_form.save()
                    return HttpResponse('Professor is successfully saved!')
                else:
                    return HttpResponse('Professor already exists!')
        return render(request, 'pmfservice/add-professor.html', {
            'form': professor_form
        })
    except Exception as e:
        return render(request, 'pmfservice/add-professor.html')
