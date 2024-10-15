import time

from django.core.mail import send_mail


def send_email(to, from_, subject, body):
    try:
        send_mail(
            subject=subject,
            message=body,
            from_email=from_,
            recipient_list=[to],
            fail_silently=False
        )

        print('email sent')

    except Exception as e:
        print(e)
