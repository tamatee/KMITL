import json
from urllib.request import Request, urlopen
req = Request('https://opend.data.go.th/get-ckan/datastore_search?resource_id=4688036a-cd89-45f7-a0c3-a34dbe35a50c&limit=5')
req.add_header('api-key', '4qQsHoYzbRlme30XZzJ35jMiDzvnNBvK')
content = urlopen(req).read()
encoding = urlopen(req).info().get_content_charset('utf-8')
JSON_object = json.loads(content.decode(encoding))
#print(JSON_object)
# formatted print
print(json.dumps(JSON_object, indent=3))