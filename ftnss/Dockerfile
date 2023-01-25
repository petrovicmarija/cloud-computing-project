FROM python:3.8.10

WORKDIR /app

COPY . .

RUN pip install -r requirements.txt
RUN pip install django-cors-headers

CMD python manage.py makemigrations && python manage.py migrate && python manage.py run server 0.0.0.0:8081