# Imports ---------------
import logging
import requests
import threading
import time
from datetime import datetime
from guizero import App, PushButton, Text


# Classes -----------
class SunriseSunset(object):
    def __init__(self, sunrise, sunset):
        self.sunrise = sunrise
        self.sunset = sunset


# Variables ------------
time_font_size = 22
date_font_size = 12


# Functions -------------
#
# {
# 	"results": {
# 		"sunrise": "6:38:14 AM",
# 		"sunset": "5:12:41 PM",
# 		"solar_noon": "11:55:27 AM",
# 		"day_length": "10:34:27",
# 		"civil_twilight_begin": "6:06:09 AM",
# 		"civil_twilight_end": "5:44:46 PM",
# 		"nautical_twilight_begin": "5:27:29 AM",
# 		"nautical_twilight_end": "6:23:25 PM",
# 		"astronomical_twilight_begin": "4:48:53 AM",
# 		"astronomical_twilight_end": "7:02:01 PM"
# 	},
# 	"status": "OK"
# }
#
def get_sunrise_times():
    url = 'https://api.sunrise-sunset.org/json?lat=51.454514&lng=-2.587910'
    data = ''
    response = requests.get(url, data=data)
    sunrise_dict = response.json()
    results_dict = sunrise_dict.results
    sunrise_obj = SunriseSunset(**results_dict)
    logging.info(sunrise_obj)
    s = SunriseSunset(response)
    return s


def update_time_thread():
    while True:
        update_time()
        time.sleep(2)


def update_time():
    now = datetime.now()
    time_string = now.strftime("%H:%M:%S")
    date_string = now.strftime("%Y-%b-%d")

    text_time.value = time_string
    text_date.value = date_string


def increase_font_size():
    text_time.text_size = text_time.text_size + 1
    text_date.text_size = text_date.text_size + 1
    update_time()


def decrease_font_size():
    text_time.text_size = text_time.text_size - 1
    text_date.text_size = text_date.text_size - 1
    update_time()


# App -------------------
logging.info("Desk Clock Starting")
app = App("Clock", layout="auto")
app.set_full_screen()
app.bg = "black"
app.text_color = (251, 251, 208)

# Widgets ---------------
# cat = Picture(app, image="tabitha.png")
# meme = Drawing(app, width="fill", height="fill")

row_nbr = 0
text_time = Text(app, text="HH:MM:SS", font="Helvetica", size=time_font_size, grid=[1, row_nbr], width="fill")
row_nbr += 1
text_date = Text(app, text="YYYY-MMM-DD", font="Helvetica", size=date_font_size, grid=[1, row_nbr], width="fill")
row_nbr += 1
button_increase_font_size = PushButton(app, text="Inc", command=increase_font_size, grid=[0, row_nbr])
button_decrease_font_size = PushButton(app, text="Dec", command=decrease_font_size, grid=[2, row_nbr])
row_nbr += 1

update_time()
# sunriseObj = get_sunrise_times()
# logging.info(sunriseObj)
x = threading.Thread(target=update_time_thread)
x.start()

# Display ---------------
app.display()
