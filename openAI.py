import openai
import os

openai.api_key = os.getenv("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")

response = openai.Completion.create(
  engine="davinci",
  prompt="Hello, how are you?",
  max_tokens=5
)

print(response["choices"][0]["text"])
