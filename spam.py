import requests

# URL ที่จะส่งข้อมูลไป
url = "https://judge.terminal8.co.th/api/submission"

# ข้อมูลที่เราจะส่ง (payload)
payload = {
    "code": "test",
    "contest_id": "3",
    "language": "C",
    "problem_id": 12
}

# เพิ่ม headers
headers = {
    "Authorization": "Bearer YOUR_ACCESS_TOKEN",  # ถ้ามี token ใช้ตรงนี้
    "User-Agent": "Python requests",
    "Content-Type": "application/json",
    "Referer": "https://judge.terminal8.co.th"  # เพิ่ม Referer header
}

# ส่งข้อมูลเป็น JSON พร้อม headers
response = requests.post(url, json=payload, headers=headers)

# ตรวจสอบสถานะการตอบกลับ
print("Status Code:", response.status_code)

# ตรวจสอบข้อความตอบกลับจากเซิร์ฟเวอร์
if response.status_code == 200:
    print("Response JSON:", response.json())
else:
    print("Error:", response.text)
